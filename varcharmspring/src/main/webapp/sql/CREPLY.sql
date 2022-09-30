CREATE TABLE CREPLY(
	RID INT auto_increment PRIMARY KEY,
	MID VARCHAR(10) NOT NULL,
	BNUM INT NOT NULL,
	CMSG VARCHAR(500) NOT NULL,
	CONSTRAINT CBOARD_CREPLY FOREIGN KEY(BNUM) REFERENCES CBOARD(BNUM) ON DELETE CASCADE
);
SELECT * FROM CREPLY;