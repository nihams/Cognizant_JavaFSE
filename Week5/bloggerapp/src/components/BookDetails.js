export const books = [
  { id: 101, bname: "Master React", price: 670 },
  { id: 102, bname: "Deep Dive Into Angular 11", price: 800 },
  { id: 103, bname: "Mongo Essentials", price: 450 },
];
function BookDetails() {
  return (
    <div>
      <h1>Book Details</h1>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            {book.bname}: Rs.{book.price}
          </li>
        ))}
      </ul>
    </div>
  );
}
export default BookDetails;
