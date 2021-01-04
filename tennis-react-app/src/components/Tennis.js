import React from 'react';

const Tennis = () => {

    function postScore(scorer){
        fetch('http://localhost:8080/tennis?scorer='+scorer)
        .then(function(response) {                     
            if(response.ok)  {
                return response.text();         
            }
        throw new Error('Game Over');
        })
        .then(function(responseText){
            document.getElementById('display-board').innerHTML = responseText;
        })
        .catch(function(error){
            document.getElementById('display-board').innerHTML = error.message;
        });
        
    }
    return (         
    <div>
        <h1>Tennis Game</h1>
        <button className='btn-player' onClick={() => postScore(1)}>Player 1 scores point</button>
        <button className='btn-player' onClick={() => postScore(2)}>Player 2 scores point</button>
        <hr/>
        <div id='display-board'></div>
    </div> );
}

export default Tennis;