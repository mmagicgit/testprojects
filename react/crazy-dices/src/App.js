import React, { Component } from 'react';
import './App.css';

class App extends Component {

  state = {
    singleResult: 0,
    multipleResult: "0"
  };

  calculateSingle = () => {
    this.setState({
      singleResult: this.refs.selected_number_single.value * this.randomNumber(this.refs.selected_type_single.value) + parseInt(this.refs.offset_single.value)
    });
  };

  calculateMultiple = () => {
    var result = "";
    for(var i=0; i < this.refs.selected_number_multiple.value; i++) {
      result += this.randomNumber(this.refs.selected_type_multiple.value) + " ";
    }
    this.setState({
      multipleResult: result
    });
  };

  randomNumber = (max) => {
    return Math.floor(Math.random() * max) + 1;
  };

  render() {
    return (
      <div>
        <h1>Crazy Dices</h1>

        <h2>Single Throw</h2>
        <select size="1" ref="selected_number_single">
          <option>1</option>
          <option>2</option>
          <option>3</option>
        </select>
        x
        W
        <select size="1" ref="selected_type_single">
            <option>6</option>
            <option>20</option>
        </select>
        +
        <input size="1" defaultValue="0" type="text" ref="offset_single"/>
        =
        {this.state.singleResult}
        <button onClick={this.calculateSingle}>Go</button>

        <h2>Multiple Throw</h2>
        <select size="1" ref="selected_number_multiple">
            <option>1</option>
            <option>2</option>
            <option>3</option>
        </select>
        x
        W
        <select size="1" ref="selected_type_multiple">
            <option>6</option>
            <option>20</option>
        </select>
        =
        {this.state.multipleResult}
        <button onClick={this.calculateMultiple}>Go</button>
      </div>
    );
  }
}

export default App;
