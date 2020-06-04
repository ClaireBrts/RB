import './App.css';
import React, { Component } from 'react';
import playLogo from './icone/play.png';
import stopLogo from './icone/stop.png';
import leftLogo from './icone/left.png';
import rightLogo from './icone/right.png';



class App extends Component {

	state = {
		url: "/rest/chenillard/",
		chenillard: { "vitesse": 600, "run": false, "sens": 1 }
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
		if (this.state.chenillard.vitesse <= 1000) {

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
	}

	async accelerer() {
		if (this.state.chenillard.vitesse >= 100) {
			console.log("Accelrer");
			return fetch(this.state.url + "getAccelerer")
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
	}


	async setVitesse(vitesse) {
		console.log("Set Vitesse")
		const chen = this.state.chenillard
		const sendChen = { vitesse: vitesse, run: chen.run, sens: chen.sens }
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

	recupVitesse = () => {
		this.setVitesse(this.vitesseRef.current.value)
		this.refresh()
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

				<div className="chenillard">Chenillard</div>



					<div>

<center>
					{(this.state.chenillard.sens === -1) ? (<img className="leftLogo" src={leftLogo} alt="leftLogo" />) : null}

						{this.state.chenillard.run ?
							(<img className="logo" src={playLogo} alt="playLogo" />)
							: (<img className="logo" src={stopLogo} alt="stopLogo" />)
						}
						{(this.state.chenillard.sens === 1) ? (<img className="rightLogo" src={rightLogo} alt="rightLogo" />) : null}
						</center>

					</div>

					<div>

					</div>

				<div>
					<button className="big-button" type="submit" onClick={() => { this.start() }}> Start</button>

					<button className="big-button" onClick={() => { this.stop() }}> Stop</button>

					<button className="big-button" onClick={() => { this.changeSens() }}> Changer de Sens</button>


					<button className="big-button" onClick={() => { this.accelerer() }}>Accelerer</button>


					<button className="big-button" onClick={() => { this.ralentir() }}>Ralentir</button>
				</div>

				<form >

					<p className="vitesseText">Vitesse {this.state.chenillard.vitesse}</p>

					<input className="inputVitesse" ref={this.vitesseRef} type="range" placeholder="Entrez une vitesse" min="100" max="1000" onChange={this.recupVitesse} step="1" value={this.state.chenillard.vitesse} />

				</form>

			</div>
		);

	}

}

export default App;
