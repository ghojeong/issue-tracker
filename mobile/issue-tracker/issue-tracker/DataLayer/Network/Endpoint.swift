//
//  Endpoint.swift
//  issue-tracker
//
//  Created by HOONHA CHOI on 2021/06/10.
//

import Foundation

enum URLRouter {
    case auth
    case issues

    func path(url: Self) -> String {
        switch self {
        case .auth:
            return "auth"
        case .issues:
            return "issues"
        }
    }
}

struct EndPoint {
    private let scheme = "http"
    private let host = "localhost"
    private let port = 8080
    private let basePath = "/api/ios/"
    private let headers = ["Content-Type": "application/json"]

    private func url(router: URLRouter) -> URL? {
        var component = URLComponents()
        component.scheme = scheme
        component.host = host
        component.port = port
        component.path = basePath + router.path(url: .auth)
        return component.url
    }

    func authURLRequest(to code: Encodable, method: Method) -> URLRequest? {
        guard let url = EndPoint().url(router: .auth) else {
            return nil
        }
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = method.description
        urlRequest.httpBody = code.encode()
        urlRequest.allHTTPHeaderFields = headers
        return urlRequest
    }
}
