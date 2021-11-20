import React, { useEffect } from 'react';
import '../css/home.css';
import ListItems from '../components/ListItems';
import AddItem from '../components/AddItem';


 
function Items(){
    

    return(
        <>
            <div className="container mt-4">
                <div className="row">
                <h4 className="text-center mb-5">To-Do List</h4>
                <AddItem/>
                <ListItems/>
                </div>

            </div>

        </>
    )

}

export default Items;