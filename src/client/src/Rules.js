import React, { Component } from 'react';
import {Link, withRouter} from "react-router-dom";
import Modal from 'react-modal'


class Rules extends Component {
    constructor(props) {
        super(props);
        this.state = {
            modalIsOpen: false,
            games:[],
            serverAddr: this.getServerAddr(),


        };

        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this);

    }

    getServerAddr(){
        return process.env.REACT_APP_SERVER_ADDR
    }

    componentDidMount() {

    }



    openModal(){
        this.setState({modalIsOpen:true})
    }
    closeModal(){
        this.setState({modalIsOpen:false})
    }


    render() {

        return (

            <div className="Home"style={{textAlignVertical: "center", textAlign: "center"}}>
                <button onClick={this.openModal}>Rules</button>
                <Modal
                    isOpen={this.state.modalIsOpen}
                    onRequestClose={this.closeModal}
                    contentLabel = "Rules"
                >
                    <button onClick={this.closeModal}>Close Rules</button>

                    <br/>
                    <h1>Rules</h1>
                    <div>
                        <li>7x7 square grid with middle 3x3 grid missing<br /></li>
                        <li>4 Unique Pieces<br /></li>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2x Rook<br />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2x Pawn<br />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1x Bishop<br />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1x King<br />
                        <li>White always moves first<br /></li>
                        <li>Two Ways to Win<br /></li>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Checkmate Enemy King<br />
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Move king to enemy king starting location through clockwise movement of king<br />
                        <br/>
                        <li>Pawn<br /></li>
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Pawn can move orthogonally or diagonally forward 1 space<br/>
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Promoted to Rook or bishop by reaching starting square of opponent pawn<br/>
                        <br/>
                        <li>Bishop<br /></li>
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Slides Diagonally forward any number of squares, with one rebound off an internal or external wall allowed<br/>
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Can also move diagonally backwards a single square<br/>
                        <br/>
                        <li>Rook<br /></li>
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Rook can move orthogonally forward any number of squares or backward a single square<br/>
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;It is also allowed a single rebound off of a corner square<br/>
                        <br/>
                        <li>King<br /></li>
                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;King can move 1 space in any direction, so long as the move does not result in check<br/>
                    </div>

                </Modal>

            </div>
        );
    }
}
export default withRouter(Rules);
