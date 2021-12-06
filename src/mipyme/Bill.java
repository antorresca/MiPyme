package mipyme;

public class Bill{
	public int Id = 0;
	public String Date;
	public Bill next = null;
	public Bill before = null;
	public String Seller;
	public String Products;
	public String Costumer;

	Bill(int id, String date, String products, String seller,String costumer){
		this.Id = id;
		this.Date = date;
		this.Products = products;
		this.Seller = seller;
		this.Costumer = costumer;
	}
}