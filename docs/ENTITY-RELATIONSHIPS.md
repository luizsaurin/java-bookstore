# 📚 Entity Relationship Overview

This project models a **Library Management System** with the following entities:

- `Book`
- `BookDetail`
- `Author`
- `Publisher`
- `Category`
- `Review`

## 🗺 Relationship Diagram (Textual ERD)

```
Publisher (1) ──────────────── (N) Book

Book (1) ───────────────────── (1) BookDetail

Book (1) ───────────────────── (N) Review

Book (N) ───────────────────── (N) Author

Book (N) ───────────────────── (N) Category
```

## 📘 Detailed Relationship Description

### Publisher → Book

**Relationship:** One-to-Many

- One Publisher can publish multiple Books.
- Each Book belongs to exactly one Publisher.
- Implemented with `@ManyToOne` in Book.
- Foreign key: `publisher_id` in `books` table.

### Book → BookDetail

**Relationship:** One-to-One

- Each Book has exactly one BookDetail.
- Each BookDetail belongs to exactly one Book.
- Implemented with `@OneToOne`.
- Foreign key: `book_id` in `book_details` table.
- `book_id` is UNIQUE.

### Book → Review

**Relationship:** One-to-Many

- One Book can have multiple Reviews.
- Each Review belongs to one Book.
- Implemented with:
	- `@OneToMany` in Book
	- `@ManyToOne` in Review
- Foreign key: `book_id` in `reviews` table.

### Book ↔ Author

**Relationship:** Many-to-Many

- A Book can have multiple Authors.
- An Author can write multiple Books.
- Implemented using a join table:
	- `book_author`
	- Columns:
		- `book_id`
		- `author_id`

### Book ↔ Category

**Relationship:** Many-to-Many

- A Book can belong to multiple Categories.
- A Category can contain multiple Books.
- Implemented using a join table:
	- `book_category`
	- Columns:
		- `book_id`
		- `category_id`

## 🧱 Database-Level Representation

**Tables:**

- `books`
- `book_details`
- `publishers`
- `authors`
- `categories`
- `reviews`
- `book_author` (join table)
- `book_category` (join table)

## 🔗 Foreign Keys Summary

| Table         | Column           | References    |
| ------------- | ---------------- | ------------- |
| books         | publisher_id     | publishers.id |
| book_details  | book_id (UNIQUE) | books.id      |
| reviews       | book_id          | books.id      |
| book_author   | book_id          | books.id      |
| book_author   | author_id        | authors.id    |
| book_category | book_id          | books.id      |
| book_category | category_id      | categories.id |

## 🧠 Conceptual Model (Domain Perspective)

- A `Publisher` publishes many books.
- A `Book` has detailed metadata stored separately.
- A `Book` can receive multiple reviews.
- A `Book` can be written by multiple authors.
- A `Book` can belong to multiple categories.