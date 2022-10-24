import React from 'react';
import logo from './logo.svg';
import './App.css';
import Addition from "./components/Addition";
import Soustraction from "./components/Soustraction";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Examen Intra</h1>
        <h2>Calculator web</h2>
      </header>
        <Addition/>
        <Soustraction/>
    </div>
  );
}

export default App;
