//App.tsx is your main component. All the React code lives here.
import React, { useState } from "react";
import "./App.css";

function App() {
    const [name, setName] = useState<string>("");
    const [counter, setCounter] = useState<number>(0);

    const handleClick = () => {
        setCounter(counter + 1);
    };

    const greetUser = () => {
        alert(`Hello again, ${name || "User"}!`);
    };

    return (
        <div className="App">
            <h1>Hello, React + TypeScript!</h1>
            <input 
                type="text" 
                placeholder="Enter your name" 
                value={name} 
                onChange={e => setName(e.target.value)} 
            />
            <button onClick={greetUser}>Greet Me</button>
            <button onClick={handleClick}>Click Me</button>
            <p>Button clicked {counter} times</p>
        </div>
    );
}

export default App;
