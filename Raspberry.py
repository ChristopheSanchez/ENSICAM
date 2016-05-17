''' Romain CHAPEL & Christophe SANCHEZ
		ENSICAEN
'''
import cv2
import socket
import numpy
import os

class Raspberry:

        _address = '192.168.1.14'
        _port = 6500
        _connexion = None

        def __init__(self):
                self._connexion = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                self._connexion.connect((self._address,self._port))

        def capture(self):
                #nom = 'hi.jpg'
                prec = 0
                capture = cv2.VideoCapture(0)
                encode_param=[int(cv2.IMWRITE_JPEG_QUALITY) ,50]
                while True :
                        retval, mat = capture.read()
                        if mat is None:
                                print 'Error'
                                continue
                        result, imgencode = cv2.imencode('.jpeg', mat, encode_param)
                        data = numpy.array(imgencode)
                        stringData = data.tostring()
                        #cv2.imwrite(nom, mat)
                        tailleImage = str(len(stringData))
                        if tailleImage == prec:
                                continue
                        prec = tailleImage
                        for i in range(8-len(tailleImage)):
                                tailleImage ='0' + tailleImage
                        #print tailleImage
                        self._connexion.send( tailleImage.encode())
                        self._connexion.send(stringData)

raspberry = Raspberry()
raspberry.capture()

