baseUrl = "http://localhost:8000/api"

async function getData(){
    const response = await fetch(baseUrl);
    return response.json();
}

async function saveData(emp){
    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-type': "application/json"
        },
        body: JSON.stringify(emp)
    });

    const data = await response.json();
    return data;
}

