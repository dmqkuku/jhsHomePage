import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from 'react';

function App() {
  const [message, setMessage] = useState([]);

  useEffect(() => {
    fetch("/home")
        .then((response) => {
          return response.json();
        })
        .then((data) => {
          setMessage(data);
        })
  })

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <ol>
          {message.map((text, idx) => <li key={`${idx}-${text}`}>{text}</li>)}
        </ol>
      </header>
    </div>
  );
}

export default App;
