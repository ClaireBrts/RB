import './App.css';
import React, { Component } from 'react';


class App extends Component {

	state = {
		url: "/rest/chenillard/",
		chenillard: ""
	}

	constructor(props) {
		super(props);
		this.vitesseRef = React.createRef();

	}

	componentDidMount() {
		this.refresh()
	}

	async refresh() {
		fetch(this.state.url + 'getChenillard/', {
			method: "GET",
			headers: {
				"Content-type": "application/json; charset=UTF-8"
			}
		}).then(res => res.json())
			.then((data) => {
				console.log(data);
				this.setState({ chenillard: data })
			})
			.catch(error => {
				this.handleError(error);
			})
	}

	async stop() {
		console.log("Stop");
		return fetch(this.state.url + 'getStop/')
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
		return fetch(this.state.url + "getStart")
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

	async changeSens() {
		console.log("ChangeSens");
		return fetch(this.state.url + "getChangeSens")
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

	async ralentir() {
		console.log("Ralentir");
		return fetch(this.state.url + "getRalentir")
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

	async setVitesse(vitesse) {
		console.log("Set Vitesse")
		const chen=this.state.chenillard
		const sendChen={ vitesse: vitesse, run: chen.run, sens: chen.sens }
		console.log(sendChen)
		return fetch(this.state.url + "postSetVitesse", {
			method: "POST",
			mode: "cors",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(sendChen)
		})
			.then(response => {
				if (!response.ok) {
					this.handleResponseError(response);
				}
				return response.json();
			})
			.catch(error => {
				this.handleError(error);
			});
	}

	recupVitesse=()=>{
		if(!isNaN(this.vitesseRef.current.value)){
		this.setVitesse(this.vitesseRef.current.value)
		}else{
			alert("Veuillez rentrer un nombre pour la vitesse");
		}
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
					<button type="submit" onClick={() => { this.start() }}> Start</button>
				</div>
				<div className="ButtonStop">
					<button onClick={() => { this.stop() }}> Stop</button>
				</div>
				<div className="ButtonSens">
					<button onClick={() => { this.changeSens() }}> Changer de Sens</button>
				</div>
				<div className="ButtonSens">
					<button onClick={() => { this.ralentir() }}>Ralentir</button>
				</div>
				<div className="chenillard">
					<title> Chenillard </title>
					{`Vitesse: ${this.state.chenillard.vitesse} Run: ${this.state.chenillard.run}  Sens: ${this.state.chenillard.sens}`}
				</div>

				<form className="form" >
					<p>
						<label>
							<input className="inputMessage" ref={this.vitesseRef} type="text" placeholder="Entrez une vitesse" />
						</label>
						<button className="sendButton" type="button" onClick={() => this.recupVitesse()}>Changer la vitesse</button>
					</p>
				</form>

			</div>
		);

	}

}

export default App;
