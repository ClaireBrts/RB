import './App.css';
import React, { Component } from 'react';


class App extends Component {

  state = {
    chenillard: ""
  }

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    fetch('/rest/chenillard/getChenillard/', {
      method: "GET",
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      }
    }).then(res => res.json())
      .then((data) => {
        console.log(data);
        this.setState({ chenillard: data })
      })
      .catch(console.log)
  }

  async stop() {
    console.log("Stop");
    return fetch('/rest/chenillard/getStop/')
      .then(response => {
        if (!response.ok) {
          this.handleResponseError(response);
        }
      })
      .catch(error => {
        this.handleError(error);
      });

  }
  async start() {
    console.log("START DIS OUI:");
    return fetch("rest/chenillard/getStart")
      .then(response => {
       if (!response.ok) {
            this.handleResponseError(response);
        }

      })
      .catch(error => {
        this.handleError(error);
      });
  }

handleResponseError(response) {
    throw new Error("HTTP error, status = " + response.status);
}
handleError(error) {
    console.log(error.message);
}

  render() {
    return (
      <div className="App">

        <div className="ButtonStart">
          <button type="submit" onClick={()=>{this.start()}}> Start</button>
        </div>
        <div className="ButtonStop">
          <button onClick={this.stop}> Stop</button>
        </div>
        <div className="chenillard">
          <title> Chenillard </title>
          {`Vitesse: ${this.state.chenillard.vitesse} Run: ${this.state.chenillard.run}  Sens: ${this.state.chenillard.sens}`}
        </div>

      </div>
    );

  }

}

export default App;
