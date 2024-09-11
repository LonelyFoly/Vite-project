import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:8090",
    headers: {
        "Content-type": "application/json",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
        "Authorization" : `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb290Iiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTcwMTE3MzgxNywiaWF0IjoxNzAxMTUyMjE3fQ.u7GgmvhGJVB4-UZnY5B76ze55M7_Paen9Sgl48j9uHQ`
    }

});
axios.defaults.headers.common = {'Authorization': `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb290Iiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTcwMTE3MzgxNywiaWF0IjoxNzAxMTUyMjE3fQ.u7GgmvhGJVB4-UZnY5B76ze55M7_Paen9Sgl48j9uHQ`}

//v2