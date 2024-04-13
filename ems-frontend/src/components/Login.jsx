import React, { useState } from 'react';


const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loggedIn, setLoggedIn] = useState(false);

  const handleLogin = async (e) => {
    e.preventDefault();
    
    if (!username || !password) {
      setError('Por favor, introduce un nombre de usuario y una contraseña');
      return;
    }
    
    try {
      const response = await fetch('http://localhost:8080/v1/users', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
      });
      
      if (response.ok) {
        console.log('Usuario autenticado');

      } else {
        setError('Credenciales incorrectas');
      }
    } catch (error) {
      console.error('Error al iniciar sesión:', error);
      setError('Hubo un problema al iniciar sesión');
    }
  };

  return (
    <div>
      <h2>Iniciar sesión</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <form onSubmit={handleLogin}>
        <div>
          <label>Nombre de usuario:</label>
          <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
        </div>
        <div>
          <label>Contraseña:</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </div>
        <button type="submit">Iniciar sesión</button>
      </form>
    </div>
  );
};

export default LoginForm;
