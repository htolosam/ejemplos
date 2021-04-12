package com.tolosa.product.app.product;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.tolosa.product.app.models.dao.IProductDao;
import com.tolosa.product.app.models.entity.Product;




@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = { 
  "amazon.dynamodb.endpoint=http://localhost:8000/", 
  "amazon.aws.accesskey=test1", 
  "amazon.aws.secretkey=test231" })
class ProductDaoConnectTests {

	private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private IProductDao repository;
    
    
    private static final String EXPECTED_COST = "20";
    private static final String EXPECTED_PRICE = "50";
    
    
//    @BeforeEach
//    public void setup() throws Exception {
//    	AmazonDynamoDB amazonDynamoDB = amazonDynamoDB();
//        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
////        
//        CreateTableRequest tableRequest = dynamoDBMapper
//          .generateCreateTableRequest(Product.class);
//        tableRequest.setProvisionedThroughput(
//          new ProvisionedThroughput(1L, 1L));
//        amazonDynamoDB.createTable(tableRequest);
//        
//        //...
//
//        dynamoDBMapper.batchDelete(
//          (List<Product>)repository.findAll());
//    }

    @Test
    void givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() { 
    	Product productInfo = new Product();
    	productInfo.setId("1");
    	productInfo.setName("prueba producto");
    	productInfo.setPrice(5000.0);
        repository.save(productInfo); 
        List<Product> result = (List<Product>) repository.findAll();
        assertTrue(result.size() > 0, "es mayor que cero");
//        assertThat(result.size(), is(greaterThan(0)));
//        assertThat(result.get(0).getCost(), is(equalTo(EXPECTED_COST))); 
    }
    
   
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB 
          = new AmazonDynamoDBClient(amazonAWSCredentials());
        
        if (!StringUtils.isEmpty("http://localhost:8000")) {
            amazonDynamoDB.setEndpoint("http://localhost:8000");
        }
        
        return amazonDynamoDB;
    }

    
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
          "123", "123");
    
    }

}
