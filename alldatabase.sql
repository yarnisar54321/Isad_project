create database sellers;
create table productList(
	productID varchar(10) Primary Key,
    productName varchar(100),
    dateModify date,
    supplierName varchar(100),
    minNumOnShelf int
);
create table productDetail(
	productID varchar(10),
    dateEXP date,
    FOREIGN KEY (productID) REFERENCES productList(productID)
);
create table stock(
	productID varchar(10),
    dateModify date,
    productNum int,
    FOREIGN KEY (productID) REFERENCES productList(productID)
);
create table withdraw(
	productID varchar(10),
    withdrawNum int,
	withdrawDate date,
    FOREIGN KEY (productID) REFERENCES productList(productID)
);
create table promotionName(
	promotionID varchar(10) Primary Key,
    promotionName varchar(100),
    promotionDiscount varchar(200)
);
create table promotionProduct(
	promotionID varchar(10),
    promotionName varchar(100),
    FOREIGN KEY (promotionID) REFERENCES promotionName(promotionID)
);