import { useState } from 'react'
import './App.css'
import Register from './Pages/auth/Register'
import Signup from './Pages/auth/SignUp'
import { Routes, Route } from 'react-router-dom'
import Login from './Pages/auth/Login'

function App() {

  return (
    <Routes>
      <Route path="/" element={<Register />}></Route>
      <Route path="/signup" element={<Signup />}></Route>
      <Route path="/login" element={<Login />} />
    </Routes>
  )
}

export default App
