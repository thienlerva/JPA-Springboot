

CREATE TABLE ERS_REIMBURSEMENT_STATUS(
    REIMB_STATUS_ID NUMBER(10) PRIMARY KEY,
    REIMB_STATUS VARCHAR2(10)
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE(
    REIMB_TYPE_ID NUMBER(10) PRIMARY KEY,
    REIMB_TYPE VARCHAR2(10)
);

CREATE TABLE ERS_USER_ROLES(
    USER_ROLE_ID NUMBER(10) PRIMARY KEY,
    USER_ROLE VARCHAR2(10)
);

CREATE TABLE ERS_USERS(
    ERS_USERS_ID NUMBER(10) PRIMARY KEY,
    ERS_USERNAME VARCHAR2(50) UNIQUE,
    ERS_USER_PASSWORD VARCHAR2(50),
    USER_FIRST_NAME VARCHAR2(100),
    USER_LAST_NAME VARCHAR2(100),
    USER_EMAIL VARCHAR2(150) UNIQUE,
    USER_ROLE_ID NUMBER(10),
    FOREIGN KEY(USER_ROLE_ID) REFERENCES ERS_USER_ROLES(USER_ROLE_ID)
);

insert into ers_users (ers_username, ers_user_password, user_first_name, user_last_name, user_email, user_role_id)
  values ('jacksmith', 'smithjack', 'Jack', 'Smith', 'jacksmith@yahoo.com', 1);

CREATE TABLE ERS_REIMBURSEMENT(
    REIMB_ID NUMBER(10) PRIMARY KEY,
    REIMB_AMOUNT NUMBER(10,2),
    REIMD_SUBMITTED VARCHAR2(100),
    REIMB_RESOLVED VARCHAR2(100),
    REIMB_DESCRIPTION VARCHAR2(250),
    REIMB_AUTHOR NUMBER(10),
    REIMB_RESOLVER NUMBER(10),
    REIMB_STATUS_ID NUMBER(10),
    REIMB_TYPE_ID NUMBER(10),
    FOREIGN KEY(REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID),
    FOREIGN KEY(REIMB_STATUS_ID) REFERENCES ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
    FOREIGN KEY(REIMB_AUTHOR) REFERENCES ERS_USERS(ERS_USERS_ID),
    FOREIGN KEY(REIMB_RESOLVER) REFERENCES ERS_USERS(ERS_USERS_ID)
);

alter table ERS_REIMBURSEMENT
add REIMB_RECEIPT BLOB;

commit;

create sequence ers_users_seq
start with 3
increment by 1;

create or replace trigger ers_users_trig
before insert on ers_users
for each row
begin
  select ers_users_seq.nextval into : NEW.ers_users_id from dual;
end;
/

create sequence ACCOUNT_TYPE_SEQ
start with 1
increment by 1;

create or replace trigger ACCOUNT_TYPE_TRIG
before insert on ACCOUNT_TYPE
for each row
begin
    
    select ACCOUNT_TYPE_SEQ.nextval into : NEW.TYPE_ID from dual;
    
end;
/

select * from ers_reimbursement;
delete from ers_reimbursement where reimb_id = 301;
commit;


CREATE OR REPLACE PROCEDURE GET_REIMBURSEMENTS(
   REIMB_ID IN NUMBER, REIMBURSEMENT_LIST OUT SYS_REFCURSOR)
   AS
   BEGIN
   OPEN REIMBURSEMENT_LIST FOR
     SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = REIMB_ID;
     commit;
    END;
/

select e1.lastname as EMPLOYEE, e2.lastname as MANAGER
from employee e1
join employee e2
on e1.reportsto = e2.employeeid;

select cust.lastname as customer, inv.billingaddress as address
from customer cust
join invoice inv
on cust.customerid = inv.customerid;

select * from employee;

delete from book where book_id =21;
