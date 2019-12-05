import React, { Component } from 'react';
import {Link, withRouter} from "react-router-dom";
import Modal from 'react-modal'


class GameHistory extends Component {
    constructor(props) {
        super(props);
        this.state = {
            modalIsOpen: false,
            games:[],


        };

        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this);
        this.updateGames = this.updateGames.bind(this)


    }

    getServerAddr(){
        return process.env.REACT_APP_SERVER_ADDR
    }

    componentDidMount() {

    }


    updateGames(){
        if(this.props.finishedGames === undefined){
            console.log("finished games in undefined")
            return
        }
        console.log("games defined printing ....")
        console.log(this.props.finishedGames)
        console.log("done printing")
        this.setState({games: this.props.finishedGames})

    }


    openModal(){
        this.setState({modalIsOpen:true})
        this.updateGames()
    }
    closeModal(){
        this.setState({modalIsOpen:false})
    }

    renderTableData(){
        console.log("games from render table data")
        console.log(this.state.games)
        console.log("end games from render table data")
        return this.state.games.map((data, index) => {
            const { id, p1, p2, startTime, endTime, Winner } = data //destructuring
            console.log("in map in render table data")
            console.log(data)
            console.log("printed data")
            return (
                <tr key={id}>
                    <td>{id}</td>
                    <td>{p1}</td>
                    <td>{p2}</td>
                    <td> {Winner}</td>
                    <td>{startTime}</td>
                    <td>{endTime}</td>
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
                    <button onClick={this.updateGames}>Update</button>
                    <table >
                        <thead>
                            <tr>
                                <th>Game ID</th>
                                <th>Player 1</th>
                                <th>Player 2</th>
                                <th>Winner</th>
                                <th>Start Time</th>
                                <th>End Time</th>
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
