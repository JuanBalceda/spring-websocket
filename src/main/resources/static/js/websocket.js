let ws = null

const setText = data => {
    const msg = `<div>${data}</div>`
    chat.insertAdjacentHTML('beforeend',msg)
}

btnConnect.addEventListener('click', event => {
    ws = new SockJS('/chat');
    stompClient = Stomp.over(ws)
    stompClient.connect({}, frame => {
        stompClient.subscribe('/topic/content', c => {
            const output = JSON.parse(c.body)
            setText(output.data)
        })
    })
    setText('Connected')
})

btnSend.addEventListener('click',  event => {
    const input = {
        name: txtName.value,
        message: txtMsg.value 
    }
    stompClient.send("/app/chat", {}, JSON.stringify(input));
})

btnDisconnect.addEventListener('click', event => {
    stompClient.disconnect()
    setText('Disconnected')
})
