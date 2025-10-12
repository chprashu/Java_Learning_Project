package learn.testService.impl;

import learn.testService.ProductService;
import learn.testVOs.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductVO saveProduct(ProductVO productVO) {
        return null;
    }

    @Override
    public ProductVO getProduct(Integer id) {
        return null;
    }

    @Override
    public List<ProductVO> getAllProducts() {
        return List.of();
    }
}
