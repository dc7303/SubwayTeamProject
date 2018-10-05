package subway.user.model.dto;

public class OrderDTO {
	private int orderId;			//주문번호
	private int orderBreadLength;	//빵길이
	private String orderMenu;		//메인메뉴
	private String orderExtra;		//추가토핑
	private String orderBread;		//빵 종류
	private String orderSauce;		//소스
	private int orderPrice;			//가격
	private int orderCalorie;		//칼로리
	private String orderUser;		//고객 아이디
	private String orderText;		//고객 요구사항
	private String orderIsMyMenu;	//나만의 메뉴
	private int orderQuantity;		//수량
	private String orderBasket;		//바스켓 아이디
	
	public OrderDTO() {}

	public OrderDTO(int orderId, int orderBreadLength, String orderMenu, String orderExtra, String orderBread,
			String orderSauce, int orderPrice, int orderCalorie, String orderUser, String orderText,
			String orderIsMyMenu, int orderQuantity, String orderBasket) {
		super();
		this.orderId = orderId;
		this.orderBreadLength = orderBreadLength;
		this.orderMenu = orderMenu;
		this.orderExtra = orderExtra;
		this.orderBread = orderBread;
		this.orderSauce = orderSauce;
		this.orderPrice = orderPrice;
		this.orderCalorie = orderCalorie;
		this.orderUser = orderUser;
		this.orderText = orderText;
		this.orderIsMyMenu = orderIsMyMenu;
		this.orderQuantity = orderQuantity;
		this.orderBasket = orderBasket;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderBreadLength() {
		return orderBreadLength;
	}

	public void setOrderBreadLength(int orderBreadLength) {
		this.orderBreadLength = orderBreadLength;
	}

	public String getOrderMenu() {
		return orderMenu;
	}

	public void setOrderMenu(String orderMenu) {
		this.orderMenu = orderMenu;
	}

	public String getOrderExtra() {
		return orderExtra;
	}

	public void setOrderExtra(String orderExtra) {
		this.orderExtra = orderExtra;
	}

	public String getOrderBread() {
		return orderBread;
	}

	public void setOrderBread(String orderBread) {
		this.orderBread = orderBread;
	}

	public String getOrderSauce() {
		return orderSauce;
	}

	public void setOrderSauce(String orderSauce) {
		this.orderSauce = orderSauce;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderCalorie() {
		return orderCalorie;
	}

	public void setOrderCalorie(int orderCalorie) {
		this.orderCalorie = orderCalorie;
	}

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

	public String getOrderText() {
		return orderText;
	}

	public void setOrderText(String orderText) {
		this.orderText = orderText;
	}

	public String getOrderIsMyMenu() {
		return orderIsMyMenu;
	}

	public void setOrderIsMyMenu(String orderIsMyMenu) {
		this.orderIsMyMenu = orderIsMyMenu;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderBasket() {
		return orderBasket;
	}

	public void setOrderBasket(String orderBasket) {
		this.orderBasket = orderBasket;
	}
	
	/**
	 * 테스트용 임시 toString
	 */
	@Override
	public String toString() {
		return orderId + " | " + orderBreadLength + " | " + orderMenu
				+ " | " + orderExtra + " | " + orderBread + " | " + orderSauce
				+ " | " + orderPrice + " | " + orderCalorie + " | " + orderUser
				+ " | " + orderText + ", orderIsMyMenu=" + orderIsMyMenu + ", orderQuantity=" + orderQuantity
				+ " | " + orderBasket;
	}
	
	
	
}
