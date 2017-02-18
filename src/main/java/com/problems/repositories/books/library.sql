USE library;

DELETE FROM books;

DROP TABLE books;

CREATE TABLE books (
  ISBN VARCHAR(50),
  title VARCHAR(30),
  author VARCHAR(30),
  rented BOOLEAN,
  overdue BOOLEAN,
  PRIMARY KEY (ISBN)
);