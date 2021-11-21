import axios from 'axios';
import React, { useState } from 'react';
import {useParams} from 'react-router';

function AddItem(){

    const [item, setItem] = useState("");
    let params = useParams();
    


    function handleItemChange(e){
        setItem(e.target.value);
    }


    function handleItemSubmit(e){
        e.preventDefault();
        axios.post("http://localhost:8080/createItem?description="+item+"&folder_id="+params.id)
            .then(response => {
                window.location.reload(true);
            })
            .catch(e => {
                console.log(e);
            })
    }

    return (
        <>
            <div className="d-grid gap-2 d-md-flex justify-content-md-end mb-3">
                <form onSubmit={handleItemSubmit}>
                        <div className="row">
                            <div className="col-md-8">
                                <input type="text" className="form-control" value={item} onChange={handleItemChange} id="item" placeholder="Take a shower"/>
                            </div>
                            <div className="text-center mt-2 mb-3 m-md-0 col-md-4">
                                <button className="btn btn-success me-md-2" type="submit">Add</button>
                            </div>

                        </div>
                   
                </form>
                
            </div>

        </>
    )


}

export default AddItem;