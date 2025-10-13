package learn.testService;

import learn.testVOs.ProductVO;

import java.util.List;

public interface ProductService {

    public ProductVO saveProduct(ProductVO productVO);

    public ProductVO getProduct(Integer id);

    public List<ProductVO> getAllProducts();
}
