package com.rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.rmiinterface.Book;
import com.rmiinterface.RMIInterface;

public class Bookstore extends UnicastRemoteObject implements RMIInterface{
	private static final long serialVersionUID = 1L;
	private List<Book> bookList;

	protected Bookstore(List<Book> list) throws RemoteException {
		super();
		this.bookList = list;
	}
	
	@Override
	public Book findBook(Book book) throws RemoteException {
		Predicate<Book> predicate = x-> x.getIsbn().equals(book.getIsbn());
		return bookList.stream().filter(predicate).findFirst().get();
		
	}
	
	@Override
	public List<Book> allBooks() throws RemoteException {
		return bookList;
	}
	
	private static List<Book> initializeList(){
		List<Book> list = new ArrayList<>();
		list.add(new Book("Book number 1", "IB-111", 1.11));
		list.add(new Book("Book number 2", "IB-222", 2.11));
		list.add(new Book("Book number 3", "IB-333", 3.11));
		list.add(new Book("Book number 4", "IB-444", 4.11));
		list.add(new Book("Book number 5", "IB-555", 5.11));
		list.add(new Book("Book number 6", "IB-666", 6.11));
		list.add(new Book("Book number 7", "IB-777", 7.11));
		return list;
	}
	
	public static void main(String[] args){
        try {
            Naming.rebind("//localhost/MyBookstore", new Bookstore(initializeList()));
            System.err.println("Server is ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
