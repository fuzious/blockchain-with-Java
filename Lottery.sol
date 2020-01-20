pragma solidity ^0.5.12;

contract Lottery {

    address public manager;
    address payable[] public players;
    
    constructor() public payable {
        manager=msg.sender;
        
    }
    
    //send some 
    function enter() public payable{
        require(msg.value > 0.01 ether);
        players.push(msg.sender);
    }
    
    function random() private view returns (uint256)    {
        return uint(keccak256(abi.encodePacked(block.difficulty, now, players)));
    }
    
    function pickWinner() public restricted {
        // require(msg.sender == manager);
        uint index=random() % players.length;
        players[index].transfer(address(this).balance);
        players=new address payable[](0);   //dynamic array with initial sizeof 0
    } 
    
    modifier restricted() {
        require (msg.sender==manager);
        _;
    }
    
    function getPlayers() public view returns (address payable[] memory) {
        return players;
    }
}