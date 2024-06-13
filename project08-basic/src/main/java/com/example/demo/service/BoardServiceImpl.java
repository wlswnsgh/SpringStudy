package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository repository;

    @Override
    public int register(BoardDTO dto) {

        System.out.println(dto);

        Board entity = dtoToEntity(dto);
        repository.save(entity);
        int newNo = entity.getNo();

        System.out.println(entity);

        return newNo;
    }

    @Override
    public List<BoardDTO> getList() {
        List<Board> result = repository.findAll();
        List<BoardDTO> list = new ArrayList<>();
        list = result.stream()
                .map(entity -> entityToDto(entity))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public BoardDTO read(int no) {

        Optional<Board> result = repository.findById(no);

        if (result.isPresent()) {
            Board board = result.get();
            BoardDTO boardDTO = entityToDto(board);
            return boardDTO;
        } else {
            return null;
        }

    }

    @Override
    public void modify(BoardDTO dto) {
        Optional<Board> result = repository.findById(dto.getNo()); 
        if (result.isPresent()) {
            Board entity = result.get();

            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());

            repository.save(entity);
        }

    }

    @Override
    public int remove(int no) {

        Optional<Board> result = repository.findById(no);

        if (result.isPresent()) {
            repository.deleteById(no);
            return 1; 
        } else {
            return 0;
        }

    }

}
