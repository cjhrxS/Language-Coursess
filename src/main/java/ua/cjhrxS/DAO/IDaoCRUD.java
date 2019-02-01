package ua.cjhrxS.DAO;

public interface IDaoCRUD<TEntity> extends IDaoRead<TEntity> {

	//Create
	boolean create();
	
	// Insert
	boolean insert(TEntity entity);

	// Update
	boolean updateByEntity(TEntity entity);
	
	boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

	// Delete
	boolean deleteById(Long id);

	boolean deleteByFieldName(String fieldCondition, String textCondition);

	boolean delete(TEntity entity);

}
