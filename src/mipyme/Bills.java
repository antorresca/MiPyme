package mipyme;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import vistas.Factura;

public class Bills{

	static Bill Head = null;
	static Bill Tail = null;
	static int Consecutive = 0;

	public void newBill(String products, String seller,String costumer){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String date = dtf.format(ZonedDateTime.now(ZoneId.of("America/Bogota")));
		Bill Bill = new Bill(Consecutive, date, products, seller,costumer); 
		addBill(Bill);
		Consecutive += 1;
	}

	public static void addBill(Bill bill){
		if(Head == null && Tail == null){
			Head = bill;
			Tail = bill;
		}else{
			Tail.next = bill;
			bill.before = Tail;
			Tail = bill;
		}
	}

	public static boolean delBill(int id) {
		Bill Eliminar = findBill(id);
		if(Eliminar == null){
			return false;
		}else{if(Eliminar == Head) {
			Head = Eliminar.next;
		}else {
			if(Eliminar == Tail) {
				Tail = Eliminar.before;
			}
		}}
		try{
			Eliminar.next.before = Eliminar.before;
		}catch(Exception e){
		}
		try{
			Eliminar.before.next = Eliminar.next;
		}catch(Exception e){
		}
		Eliminar.before = null;
		Eliminar.next = null;
		return true;
	}

	public static Bill findBill(int id) {
		if(id<Consecutive && Head != null){
			if(Head!= null && Head.Id == id){
				return Head;
			}else{
				if(Tail!= null && Tail.Id == id){
					return Tail;        
				}else{
					Bill Temp = Head;
					while(Temp.Id != id && Temp.next != null){
						Temp = Temp.next;            
					}
					if(Temp.Id == id){
						return Temp;
					}
				}
			}
		}
		return null;
	}

	public void printBill(int id) {
		Bill Imprimir = findBill(id);
		vistas.Factura.main(Imprimir);
	}
	
	public void printLastBill() {
		Bill Imprimir = findBill(Consecutive-1);
		System.out.print(Imprimir.Costumer);
		vistas.Factura.main(Imprimir);
	}
}