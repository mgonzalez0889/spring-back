package com.example.demo.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.123456";
	
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEA15DdQh/BFBMJMiAv9n75TrjGJ3Ix4uvHv2pjEzA1iXT2Alzz\r\n"
			+ "hV/8V+yXaSJbFZI8TAwz6uy5aOMrll5zjEE0rX0kqdwMclXiDNu08TnmPgnxbTmQ\r\n"
			+ "SCorAwBZwopPtuerKjmdNVyD1CYqxabNR7gDImDIKv42wjVev4hv5Vm39W8gMfbB\r\n"
			+ "5I6mFQyOgXrk+/5kBmTfILhSuSu+U6+frlfYEy8q4sX+KJsa5i807cSZTAEQ9803\r\n"
			+ "AEj0GSp5hXVEhvS8rnSiOlfd2a2j0C0To5BQrCZiLPkHcTsrl/4hqTxlGxZu5mjb\r\n"
			+ "f3PCl3Z+mIWNeWKdqzp691HxTn2iUgXK0jhlewIDAQABAoIBAQCNurhOrnQSz8U/\r\n"
			+ "CLygM7GU2ZWm/8Te7qjBKKCFUDAS9Sx+N0EBUy+lW2/ddvIuB5zPX0KPVh89YAcb\r\n"
			+ "cXRFJeYNnvcJGx2v2tmqHJYl+CxyY7UxXCSJ3feznHpnlup8VmtKcuDy4aXnSUTb\r\n"
			+ "+SSE3+5nnvxckBHOtKpcAceYItn5amYDzpmg6iEapnnSE81wGojhilpTKqMufFdC\r\n"
			+ "hqN0Nsk7bp9peK38KTIpAcNYVFce5GSjHM47e7KIgPvARNs9cQsZ+t41wO3cm8wC\r\n"
			+ "njq1fiwtrCBbcylQ20l+GqfTRbIVLiMhtBYEz00bw1Bf/qXJcGi8omXn5ti8zESQ\r\n"
			+ "3VBrrGJhAoGBAP4Zidl9FdaF/HAmELG02ovUop89Cq9LfgwDX9QYX6m7fb8plcpg\r\n"
			+ "//0hEUZrqhKEWj8ByY8F4/ixeTY8lQoLYDVeXQW0kxHQWUZQfDZD6DQZE7r/Jb49\r\n"
			+ "GZ0vOOBjGq9vEVIhaGddxjepmbCMy6XfnSpwkhObcMHL6REApAWcfMFxAoGBANkt\r\n"
			+ "jflSVy117yj1ddYGh5vtLaAiMpmmBAYIJo03UB6xMShHRvvo4ad2OvC/W/K96TW3\r\n"
			+ "bt5tapWhmSDRfW9vT1iaYxNG/kfDtnNcIypWZqjSvKLkWPhYCsB9vfcuiT6kE0Y6\r\n"
			+ "Zf8GfTYqcT0gXaIiwA924gSpfCVYyLYZWeubnp+rAoGAZ2Sm5dtzBl5wsIWcp2Kq\r\n"
			+ "xtkX7umcrmVufZ7l4FymmF8VNLLMI5RCtZI+AESQ6IX4XsjwZgUElU5Jvxr5niOw\r\n"
			+ "2yZxfX/TlB0OJoFbeY06L/DASYfGqNkd0grD/vH0iswL5Tp4zA6pOD8HrYIs32rU\r\n"
			+ "/c7ecaH/SKwbQvLayvm4/dECgYALTofZtyO6xi0RYNYlsmlVAOAjOiSQQ0hqV/pJ\r\n"
			+ "19tf/bGlezCC5Pj6kvk2l3/d/20o0sf+5ItsBuHGB6IULyNeZYtK8aNDcTkKgH2E\r\n"
			+ "MsNdfrs7b9AB/fNxWhqNx+p1TG2Edn3g7SGPtF345Lp7OnvtUi8qNvizqQ+qC1/X\r\n"
			+ "GF8FyQKBgQCWubEgqmY7MJLRLhH7LVqpoJBrbYVk9e9t8NudgTn2iCD3MH6I72Ky\r\n"
			+ "f5tZALI2hbBi1a/KvU80DGoNHm42vWs1Wtl7b/wm5FhPvCXAdptduSAsPoLz+7qa\r\n"
			+ "QX1A73r1KSG95A7AWG4xV/zldA9ky+ji6+JbeE5qeimbp18eOzxCrQ==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA15DdQh/BFBMJMiAv9n75\r\n"
			+ "TrjGJ3Ix4uvHv2pjEzA1iXT2AlzzhV/8V+yXaSJbFZI8TAwz6uy5aOMrll5zjEE0\r\n"
			+ "rX0kqdwMclXiDNu08TnmPgnxbTmQSCorAwBZwopPtuerKjmdNVyD1CYqxabNR7gD\r\n"
			+ "ImDIKv42wjVev4hv5Vm39W8gMfbB5I6mFQyOgXrk+/5kBmTfILhSuSu+U6+frlfY\r\n"
			+ "Ey8q4sX+KJsa5i807cSZTAEQ9803AEj0GSp5hXVEhvS8rnSiOlfd2a2j0C0To5BQ\r\n"
			+ "rCZiLPkHcTsrl/4hqTxlGxZu5mjbf3PCl3Z+mIWNeWKdqzp691HxTn2iUgXK0jhl\r\n"
			+ "ewIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
