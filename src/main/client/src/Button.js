import React, { Component, Fragment } from 'react'
import socketIOClient from "socket.io-client";

import './Button.css'

//test

var socket;
class Button extends Component {

    state = {
        endpoint: "http://localhost:3001",
        cmd: '',
    }

    constructor(props) {
        super(props);
        this.cmdRef = React.createRef();
        socket = socketIOClient(this.state.endpoint);
    }

    onSubmitEvent = event => {
        event.preventDefault();
        console.log("cmd " + this.state.cmd);
    }

    render() {
        return (
            <div>
                    <button type="Start" ref="h" onSubmit={this.onSubmitEvent}> Start</button>
            </div>
        )
    }


}
export default Button;