package com.tms.projectDetails;


/*
================================= [] Tender Management System [] =======================================================

Built by: Naman Kumar Singh_(fw19_0458)

Domain Description:
Whenever a company  requires a service / merchandise , a tender is floated. Company maintains an empaneled list of
Vendors. An empaneled vendor can only bid for a tender. Every vendor can bid only once against   each tender. Against
each tender there may be   bids from several vendors. The company will then select the most suitable bid and places
the order to that vendor.

There are 2 users in the system:
1. Administrator
2. Vendor

========================================================================================================================

The Role of Administrator is:
1. Login with his account.
2. Register new Vendor. (assign a new username and password to him)
3. View all the vendors.
4. Create new tenders.
5. View All the Tenders.
6. View All the Bids of a tender.
7. Assign tender to a vendor.

========================================================================================================================

The Role of a Vendor is:
1. Login with his account (username and password given by admin)
1. View all the current Tenders.
2. Place a Bid against a Tender.
3. View status of a Bid(Whether Selected or Not)
4. View his own Bid History.


========================================================================================================================

[] Database: tms []


[] Tables []

create table vendor(
	vid int primary key auto_increment,
	vname varchar(15),
	vemail varchar(20) unique,
	vpassword varchar(10),
	vmobile int not null,
	vaddress varchar(25)
);

create table tender(
	tid int primary key auto_increment,
	tname varchar(20) unique,
	tdeadline date,
	tamount int
);

create table bid(
	bid int ,
	btid int,
	bamount int,
	foreign key(bid) references vendor(vid),
	foreign key(btid) references tender(tid)
);

create table bid_stat(
	rid int,
	tid int,
	stat varchar(10),
	foreign key(rid) references vendor(vid),
	foreign key(tid) references tender(tid)
);

 */
public class ProjectDetails {
}
