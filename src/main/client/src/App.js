import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';


class App extends Component {

  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="App">
        <div className="ButtonStart">
          <button type="submit" ref="buttonStart" onSubmit={this.onSubmitEvent}> Start</button>
        </div>
        <div className="ButtonStop">
          <button type="submit" ref="buttonStop" onSubmit={this.onSubmitEvent}> Start</button>
        </div>
      </div>
    );

}

}

export default App;
