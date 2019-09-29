import React, { Component } from 'react';
import { withRouter } from "react-router-dom";

class Home extends Component {
    constructor() {
        super();
        this.state = {
            email: '',
            password: '',
            error: '',
        };


    }

    render() {
        return (
            <div>
                <header>
                    <p>
                        Home
                    </p>
                </header>
                <h1>Hi {this.props.updateUser}!</h1>
            </div>
        );
    }
}
export default withRouter(Home);
