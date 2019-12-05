import React, { Component } from 'react';
import {Link, withRouter} from "react-router-dom";
import Modal from 'react-modal'
import Table from "react-bootstrap/Table";
import Cookies from "./Cookies";
import request from "request";

class GameHistory extends Component {
    constructor(props) {
        super(props);
        this.state = {
            modalIsOpen: false,
            columns: this.makeColumns(),
            data: this.makeData(),
            games:'',


        };

        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this)


    }

    getServerAddr(){
        return process.env.REACT_APP_SERVER_ADDR
    }

    componentDidMount() {
        this.makeData()
    }

    makeColumns(){

        return [
            {
                Header: "Game History",
                columns: [
                    {
                        Header: "Player 1",
                        accessor: 'p1'
                    },
                    {
                        Header: "Player 2",
                        accessor: 'p2'
                    }
                ]
            }
        ]
    }



    makeData(){

        return [
            {
            id: 1234,
            p1:"Jared",
            p2: "alex"
        },
            {
                id: 345,
                p1:"Joe",
                p2: "Bob"
            }
        ]
    }

    openModal(){
        this.setState({modalIsOpen:true})
    }
    closeModal(){
        this.setState({modalIsOpen:false})
    }

    renderTableData(){

        return this.state.data.map((data, index) => {
            const { id, p1, p2, ready } = data //destructuring
            console.log("in map in render table data")
            console.log(data)
            console.log("printed data")
            return (
                <tr key={id}>
                    <td>{id}</td>
                    <td>{p1}</td>
                    <td>{p2}</td>
                </tr>
            )
        })
    }

    render() {

        return (

            <div className="Home"style={{textAlignVertical: "center", textAlign: "center"}}>
                <button onClick={this.openModal}>Game History</button>
                <Modal
                    isOpen={this.state.modalIsOpen}
                    onRequestClose={this.closeModal}
                    contentLabel = "Game History"
                >
                    <button onClick={this.closeModal}>Close Game History</button>

                    <table >
                        <thead>
                            <tr>
                                <th>Game ID</th>
                                <th>Player 1</th>
                                <th>Player 2</th>
                            </tr>
                        </thead>
                        <tbody>
                                {this.renderTableData()}
                        </tbody>
                    </table>

                </Modal>


            </div>
        );
    }
}
export default withRouter(GameHistory);
