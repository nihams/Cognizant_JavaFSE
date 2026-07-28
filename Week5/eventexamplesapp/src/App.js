import { useState } from "react";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);
  const [rupees, setRupees] = useState("");
  const [euros, setEuros] = useState("");

  function increment() {
    setCount(count + 1);
  }
  function decrement() {
    setCount(count - 1);
  }
  function sayHello() {
    alert("Hello");
  }
  function handleIncrement() {
    increment();
    sayHello();
  }
  function welcome(message) {
    alert(message);
  }
  function pressed(event) {
    alert("I was clicked");
  }
  function handleSubmit() {
    const euro = rupees * 0.0092;
    setEuros(euro);
  }
  return (
    <div>
      <h3>{count}</h3>

      <button onClick={handleIncrement}>Increment</button>
      <button onClick={decrement}>Decrement</button>
      <button onClick={() => welcome("Welcome")}>Say Welcome</button>
      <button onClick={pressed}>Click</button>

      <h2>Currency Converter!</h2>
      <input
        type="number"
        placeholder="Enter Rupees"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      ></input>
      <button onClick={handleSubmit}>Convert</button>
      <p>Euros: {euros}</p>
    </div>
  );
}

export default App;
