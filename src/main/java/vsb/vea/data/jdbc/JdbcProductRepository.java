package vsb.vea.data.jdbc;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import vsb.vea.data.irepositories.IProductRepository;
import vsb.vea.models.Product;

@Repository
@ConditionalOnProperty(
		  value="dataAccessSource", 
		  havingValue = "jdbc", 
		  matchIfMissing = true)
public class JdbcProductRepository extends JdbcBaseRepository<Product>  implements IProductRepository {

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByEAN(String ean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameOrEAN(String filter) {
		// TODO Auto-generated method stub
		return null;
	}


}
