import "./App.css";

const office = {
  name: "Smart Office",
  rent: 55000,
  address: "Chennai",
};

const officeList = [
  {
    name: "Smart Office",
    rent: 55000,
    address: "Chennai",
    image: "https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=500",
  },
  {
    name: "Tech Park",
    rent: 75000,
    address: "Bangalore",
    image: "https://images.unsplash.com/photo-1497366412874-3415097a27e7?w=500",
  },
  {
    name: "Business Hub",
    rent: 45000,
    address: "Hyderabad",
    image: "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500",
  },
];
function App() {
  return (
    <div className="container">
      <h1>Office Space Rental App</h1>

      <h2>Featured Office</h2>
      <img
        src="https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=500"
        alt="Office Space"
        width="300"
      />

      <p>
        <b>Name:</b> {office.name}
      </p>
      <p
        style={{
          color: office.rent < 60000 ? "red" : "green",
        }}
      >
        <b>Rent:</b> {office.rent}
      </p>
      <p>
        <b>Address:</b> {office.address}
      </p>
      <hr />

      <h2>Available Office Spaces</h2>

      {officeList.map((item, index) => (
        <div className="card" key={index}>
          <img src={item.image} alt={item.name} width="300" />
          <h3>{item.name}</h3>
          <p
            style={{
              color: item.rent < 60000 ? "red" : "green",
            }}
          >
            Rent: {item.rent}
          </p>
          <p>Address: {item.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
