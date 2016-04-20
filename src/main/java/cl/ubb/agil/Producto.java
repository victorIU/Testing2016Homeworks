package cl.ubb.agil;

public class Producto {

	Categoria categoria;
	Existencia existencias[];
	String nombre;
	int stock;
	int stock_minimo;
	int stock_maximo;
	
	public Producto (String nombre, int stock_minimo, int stock_maximo, Categoria categoria){
		this.categoria = categoria;
		this.nombre = nombre;
		this.stock_maximo = stock_maximo;
		this.stock_minimo = stock_minimo;
		stock = 0;
		existencias = new Existencia[stock_maximo];		
	}
	
	public Producto (String nombre, int stock_minimo, int stock_maximo){	
		this.nombre = nombre;
		this.stock_maximo = stock_maximo;
		this.stock_minimo = stock_minimo;
		stock = 0;
		existencias = new Existencia[stock_maximo];		
	}
	
	
	public int getStock() {
		return stock;
		
	}
	
	public boolean isBajoStock() {
		if(stock<stock_minimo)
			return true;
		else
			return false;
		
	}

	public int getStockFaltante() {
		return stock_maximo-stock;		
	}
	
	public Existencia getProximaExistencia() throws ExcepcionDeProducto {
		if(stock>0){
			Existencia e = existencias[(stock-1)];
			existencias[(stock-1)] = null;
			stock--;
			return e;
		}else{
			throw new ExcepcionDeProducto();
		}
			
		
	}
	
	
	public boolean addExistencia(Existencia existencia) {
		if(stock <= stock_maximo){
			existencias[stock] = existencia;
			stock++;
			return true;
		}else{
			return false;
		}
		
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoProximaExistencia() throws ExcepcionDeProducto{
		if(stock>0){
			if(categoria == null ){
				return "XXXXX-"+ existencias[(stock-1)].getNumero();
			}else{
				return categoria.getCodigo() + "-"+ existencias[(stock-1)].getNumero();
			}
		}else{
			throw new ExcepcionDeProducto();
		}
		
	}
	
}
