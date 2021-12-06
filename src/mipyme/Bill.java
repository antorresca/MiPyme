package mipyme;

public class Bill{
	public int Id;
	public String Date;
	public Bill next = null;
	public Bill before = null;
	public String Seller;
	public String Products;

	Bill(int id, String date, String products, String seller){
		this.Id = id;
		this.Date = date;
		this.Products = products;
		this.Seller = seller;
	}
}