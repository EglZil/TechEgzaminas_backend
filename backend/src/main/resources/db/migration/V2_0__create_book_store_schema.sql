CREATE TABLE BOOK_STORE (
	ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
	NAME CHARACTER VARYING(30),

	CONSTRAINT BOOK_STORE_PK PRIMARY KEY (ID)
)