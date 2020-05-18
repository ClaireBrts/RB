import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';

//

class App extends Component {

  state={
    chenillard: null
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
    })

    .then(res =>
    {
    console.log(typeof res.json())
     return res.json()
    }
    )
     .then(data => {
        console.log(typeof data);
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
