package com.myRetailService.poc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myRetailService.poc.exception.ProductNotFoundException;
import com.myRetailService.poc.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Component
public class RedskyService {

    private RestTemplate rest;
    private HttpHeaders headers;
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public RedskyService() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    public Product getRedskyProduct(String id) {

        String serviceURL = "https://redsky.target.com/v3/pdp/tcin/" +
                id + "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews," +
                "rating_and_review_statistics,question_answer_statistics&key=candidate";
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        try {
            Product product = new Product();
            ResponseEntity<String> responseEntity = rest.exchange(serviceURL, HttpMethod.GET, requestEntity, String.class);
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Map> map = mapper.readValue(responseEntity.getBody(), Map.class);
            Map<String, Map> pMap = map.get("product");
            Map<String, Map> iMap = pMap.get("item");
            Map<String, String> tMap = pMap.get("item");
            Map<String, String> productDescMap = iMap.get("product_description");
            product.setId(tMap.get("tcin"));
            product.setpName(productDescMap.get("title"));
            return product;
        } catch (Exception ex) {
            LOG.error("Redsky Product Not Found: " + ex.getMessage());
            throw new ProductNotFoundException("Redsky Product Not Found for id: " + id);
        }
    }
}
