import './App.css';
import React, { Component } from 'react';


class App extends Component {

  state = {
    url : "/rest/chenillard/",
    chenillard: ""
  }

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    this.refresh()
  }

  async refresh() {
    fetch(this.state.url +'getChenillard/', {
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
    return fetch(this.state.url +'getStop/')
      .then(response => {
        if (!response.ok) {
          this.handleResponseError(response);
        }
        else {
          this.refresh()
        }
      })
      .catch(error => {
        this.handleError(error);
      });

  }

  async start() {
    console.log("START:");
    return fetch(this.state.url +"getStart")
      .then(response => {
        if (!response.ok) {
          this.handleResponseError(response);
        }
        else {
          this.refresh()
        }
      })
  }

      })
      .catch(error => {
        this.handleError(error);
      });
  }

  async changeSens() {
      console.log("ChangeSens");
      return fetch(this.state.url +"getChangeSens")
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
          <button onClick={()=>{this.stop()}}> Stop</button>
        </div>
        <div className="ButtonSens">
          <button onClick={()=>{this.changeSens()}}> Changer de Sens</button>
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
