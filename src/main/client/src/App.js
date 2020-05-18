import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';

//            {`Vitesse: ${this.state.chenillard.vitesse} Run: ${this.state.chenillard.run}  Sens: ${this.state.chenillard.sens}`}

class App extends Component {

  state={
    chenillard: null
  }

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    fetch('http://localhost:9999/rest/chenillard/getChenillard/',{ mode: "no-cors"})
      .then(res => res.json())
      .then((data) => {
        this.setState({ chenillard: data })
      })
      .catch(console.log)
  }



  render() {
    return (
      <div className="App">

            <div className="ButtonStart">
              <button type="submit" ref="buttonStart" onSubmit={this.onSubmitEvent}> Start</button>
            </div>

            <div className="ButtonStop">
              <button type="submit" ref="buttonStop" onSubmit={this.onSubmitEvent}> Stop</button>
            </div>
            <div className="chenillard">
            <title> Chenillard </title>
            </div>


        </div>
    );

}

}

export default App;
