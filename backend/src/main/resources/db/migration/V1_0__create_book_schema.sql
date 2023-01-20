CREATE TABLE BOOK (
	ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
	CREATED_BY CHARACTER VARYING(255),
	CREATED_DATE TIMESTAMP,
	DESCRIPTION CHARACTER VARYING(255),
	MODIFIED_BY CHARACTER VARYING(255),
	MODIFIED_DATE TIMESTAMP,
	NAME CHARACTER VARYING(30),
	AUTHOR CHARACTER VARYING(30),
	BOOK_STORE_ID BIGINT,
	"BOOK_TYPE" INTEGER NOT NULL,

	CONSTRAINT BOOK_PK PRIMARY KEY (ID)
)